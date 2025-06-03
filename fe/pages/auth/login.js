'use client';

import { useState } from 'react';
import { useForm } from 'react-hook-form';
import { Button } from '@/components/components/ui/button';
import { Input } from '@/components/components/ui/input';
import { Label } from '@/components/components/ui/label';
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from '@/components/components/ui/card';
import Image from 'next/image';
import Link from 'next/link';
import { useRouter, useSearchParams } from 'next/navigation';
import { Eye, EyeOff } from 'lucide-react';
import { Dialog, DialogContent, DialogHeader, DialogTitle, DialogTrigger } from '@/components/components/ui/dialog';
import { useAuth } from 'context/AuthProvider';
import { toast } from 'sonner';
import AuthLayout from './auth-layout';

export default function LoginForm() {
	const [loading, setLoading] = useState(false);
	const [forgotLoading, setForgotLoading] = useState(false);
	const [showPassword, setShowPassword] = useState(false);
	const [showForgotDialog, setShowForgotDialog] = useState(false);
	const router = useRouter();
	const { login } = useAuth();
	const searchParams = useSearchParams();
	const callbackUrl = searchParams.get('callbackUrl') || '/';

	const {
		register,
		handleSubmit,
		formState: { errors },
		reset,
	} = useForm();

	const {
		register: registerForgot,
		handleSubmit: handleForgotSubmit,
		formState: { errors: forgotErrors },
		reset: resetForgot,
	} = useForm();

	const onSubmit = async (data) => {
		setLoading(true);
		try {
			const response = await fetch('https://duongcongson-001-site1.jtempurl.com/api/Auth/login', {
				method: 'POST',
				headers: { 'Content-Type': 'application/json' },
				body: JSON.stringify(data),
			});

			const responseData = await response.json();

			if (response.ok) {
				const accessToken = responseData.accessToken;
				const refreshToken = responseData.refreshToken;
				const role = responseData.role;
				localStorage.setItem('accessToken', accessToken);
				localStorage.setItem('refreshToken', refreshToken);
				login({ accessToken, refreshToken });

				toast.success('Login successful! Redirecting...');
				reset();
				role === 'Manager'
					? router.push('/manager')
					: role === 'Admin'
					? router.push('/admin')
					: router.push(callbackUrl);
			} else {
				console.error('Login failed:', responseData);
				toast.error(`Login failed: ${responseData.message || 'Invalid credentials'}`);
			}
		} catch (error) {
			console.error('Login error:', error);
			toast.error('An error occurred during login. Please try again later.');
		} finally {
			setLoading(false);
		}
	};

	const onForgotSubmit = async (data) => {
		setForgotLoading(true);
		try {
			const response = await fetch('https://duongcongson-001-site1.jtempurl.com/api/Auth/forgot-password', {
				method: 'PUT',
				headers: { 'Content-Type': 'application/json' },
				body: JSON.stringify(data),
			});
			if (response.ok) {
				toast.success('Password reset email sent!');
				resetForgot();
				setShowForgotDialog(false);
			} else {
				toast.error('Failed to send reset email.');
			}
		} catch (error) {
			toast.error('An error occurred. Please try again.');
		} finally {
			setForgotLoading(false);
		}
	};

	return (
		<AuthLayout>
			<div className='relative flex items-center justify-center p-4 bg-gray-100 h-dvh'>
				<Image src='/images/authen/bg-authen.jpg' fill alt='bg-authen' />
				<Card className='relative z-50 w-full max-w-xl bg-white/80'>
					<CardHeader>
						<CardTitle>Login</CardTitle>
						<CardDescription>Sign in to your account.</CardDescription>
					</CardHeader>
					<form onSubmit={handleSubmit(onSubmit)}>
						<CardContent className='space-y-4'>
							<div className='space-y-2'>
								<Label htmlFor='email'>Email</Label>
								<Input
									id='email'
									type='email'
									{...register('email', { required: 'Email is required' })}
									className='border border-black'
									placeholder='john@example.com'
								/>
								{errors.email && <p className='text-sm text-red-500'>{errors.email.message}</p>}
							</div>
							<div className='space-y-2'>
								<Label htmlFor='password'>Password</Label>
								<div className='relative'>
									<Input
										id='password'
										type={showPassword ? 'text' : 'password'}
										{...register('password', { required: 'Password is required' })}
										className='pr-10 border border-black'
										placeholder='*******'
									/>
									<button
										type='button'
										onClick={() => setShowPassword(!showPassword)}
										className='absolute inset-y-0 flex items-center right-3'
									>
										{showPassword ? <EyeOff size={20} /> : <Eye size={20} />}
									</button>
								</div>
								{errors.password && <p className='text-sm text-red-500'>{errors.password.message}</p>}
							</div>
							<div className='text-sm'>
								Don't have an account?{' '}
								<Link href='/auth/register' className='text-blue-500 hover:underline'>
									Register
								</Link>
							</div>
						</CardContent>
						<CardFooter className='flex flex-col'>
							<Button type='submit' className='w-full' disabled={loading}>
								{loading ? 'Logging in...' : 'Login'}
							</Button>
							<div className='mt-4 text-center'>
								<Dialog open={showForgotDialog} onOpenChange={setShowForgotDialog}>
									<DialogTrigger asChild>
										<button type='button' className='text-sm text-blue-500 hover:underline'>
											Forgot Password?
										</button>
									</DialogTrigger>
									<DialogContent>
										<DialogHeader>
											<DialogTitle>Forgot Password</DialogTitle>
										</DialogHeader>
										{/* Completely separate form for forgot password */}
										<div className='flex flex-col gap-3'>
											<Label htmlFor='forgot-email'>Email</Label>
											<Input
												id='forgot-email'
												{...registerForgot('email', { required: 'Email is required' })}
												placeholder='Enter your email'
											/>
											{forgotErrors.email && (
												<p className='text-sm text-red-500'>{forgotErrors.email.message}</p>
											)}
											<Button
												type='button'
												disabled={forgotLoading}
												onClick={handleForgotSubmit(onForgotSubmit)}
											>
												{forgotLoading ? 'Submitting...' : 'Submit'}
											</Button>
										</div>
									</DialogContent>
								</Dialog>
							</div>
						</CardFooter>
					</form>
				</Card>
			</div>
		</AuthLayout>
	);
}